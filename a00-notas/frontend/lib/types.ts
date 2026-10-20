import { UUID } from "crypto"

export type Note = {
    id: string;
    title: string;
    content: string;
    createdAt: string;
};

export type NoteInput = Pick<Note, "title" | "content"> ;