import { createResource } from "./api";
import { Note, NoteInput } from "./types";
import { revalidatePath } from "next/cache";
import { redirect } from 'next/navigation';


const notesApi = createResource<Note, NoteInput>("note");

export type FormState = {error?: string};

export async function getNotes() {
    return notesApi.findAll()
}

export async function getNoteById(id: string) {
    return notesApi.findById(id);
}


function readForm(formData: FormData): NoteInput{
    const title = String(formData.get("title") ?? "").trim();
    const content =  String(formData.get("content") ?? "").trim();
    return {title, content}
}


function validate(note: NoteInput): string | null {
    if(note.title === ""){
        return "El titulo no puede estar vacio";
    }
    return null;
}

export async function create(formData: FormData): Promise<FormState> {
    const note = readForm(formData);
    const error = validate(note);
    if(error){
        return {error};
    }
    const created = await notesApi.create({
        title: note.title,
        content: note.content
    });

    revalidatePath("/");
    redirect("/api/v1/notes" + created.id);
}

export async function update(id:string, formData: FormData) {
    const note = readForm(formData);
    const error = validate(note);
    if(error){
        return {error};
    }

    await notesApi.update(id, note);
    revalidatePath("/");
    redirect("/api/v1/notes");
}

export async function remove(id:string) {
    await notesApi.delete(id);
    revalidatePath("/");
    redirect("/api/v1/notes");
    
}