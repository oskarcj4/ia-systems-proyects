import Link from "next/link";
import { ComponentProps } from "react";
const variants = {
    primary: 'bg-indigo-500 text-white hover:bg-indigo-600',
    secondary: 'bg-zinc-500 text-white hover:bg-zinc-600',
    danger: 'bg-red-500 text-white hover:bg-red-600',
};


const base = "inline-flex items-center gap-2 rounded-lg px-4 py-2 text-sm font-medium transition disabled:opacity-50";
type Variant = keyof typeof variants;

type ButtonProps = ComponentProps<"button"> & ({variant ?:Variant});

export function Button({variant = "primary", className = "", ... props}: ButtonProps) {
    const classes = `${base} ${variants[variant]} ${className}`;

    return <button className={classes} {...props} />

}

type LinkButton= ComponentProps<typeof Link> & ({variant ?:Variant});

export function LinkButton({variant= 'primary', className ="", ...props}: LinkButton) {
    const classes = `${base} ${variants[variant]} ${className}`;
    return <Link className={classes} {...props} />
}

