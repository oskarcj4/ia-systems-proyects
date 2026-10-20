import Link from "next/link";
import Note from "@/lib/types";
export function NoteCard({note}: {note: Note}) {
    const date = new Date(note.createdAt).toLocaleDateString("es-GT");


    return (
        <Link href={`/api/v1/notes/${note.id}`} className="block transition hover:-translate-y-0.5"> 
        
        </Link>
    );

}

