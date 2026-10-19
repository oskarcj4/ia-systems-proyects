import { UUID } from "crypto"

export type Note = {
    id: UUID;
    title: string;
    content: string;
    createdAt: string;
};

export type NoteInput = Pick<Note, "title" | "content"> ;