import { ComponentProps } from "react";

const field = "border border-gray-300 rounded-md px-3 py-2 focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-blue-500";

type InputProps = ComponentProps<"input"> & {label?: string};


export default function Input({label, ...props}: InputProps) {
    return (
        <label className="block space-y-1">
            <span className="text-sm font-medium text-gray-700">{label}</span>
            <input className={field} {...props} />
        </label>
    );
}

type TextareaProps = ComponentProps<"textarea"> & {label?: string};

export function Textarea({label, ...props}: TextareaProps) {

    return (
        <label>
            <span className="text-sm font-medium text-gray-700">{label}</span>
            <textarea className={`${field} min-h-40`} {...props} />
        </label>
    );

}