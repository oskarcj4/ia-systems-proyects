import { UUID } from "crypto";
import { env } from "process";

const BASE = process.env.API_BASE ?? "http://localhost:8080"

export class ApiError extends Error {
    constructor(public status : number, message:string){
        super(message);
    }
}

async function request<T>(method: string, path: string, body ?:unknown): Promise<T> {
    const url = BASE + path;

    const options:RequestInit = {
        method : method,
        headers : {"Content-Type" : "application/json"},
        cache: "no-store",
    };

    if(body){
        options.body= JSON.stringify(body);
    }

    let response :Response;

    try{
        response = await fetch(url, options);
    } catch {
        throw new ApiError(503, "No se pudo conectar con la API");
    }
    if(!response.ok){
        throw new ApiError(response.status, "${method} ${path} respondio.");
    }
    if(response.status === 204){
        return undefined as T;
    }

    const data = await response.json();
    return data as T;

}

export function createResource<T, TInput> (name:string) {
    const basePath = `/${name}`

    return {
        findAll: () => request<T[]>('GET', basePath, "?_sort=-createdAt"),
        findById: (id : string) => request<T>("GET", basePath + "/" + id),
        create: (data: TInput) => request<T>("POST", basePath, data),
        update: (id:string, data: Partial<TInput>) => request<T>("PUT", basePath + "/" + id, data),
        delete: (id: string) => request<T>("DELETE", basePath + "/" +id) 
    }
}