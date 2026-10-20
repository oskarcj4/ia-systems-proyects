type CardProps = {
    children: React.ReactNode;
    className?: string;
}


export function Card({children, className =""}: CardProps) {
    return (
        <div className= {`rounded-xl border border-zinc-200 bg-white p-5 shadow-sm dark:border-zinc-800 dark-bg-zic-900 ${className}`} >
            {children}
        </div>
    );

}