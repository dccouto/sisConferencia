import React from 'react'

interface AvisoSemRegistrosProps {
    children: React.ReactNode | React.ReactNode[]
}

export function FooterActions({ children }: AvisoSemRegistrosProps) {
    return <div className='footer-actions'>{children}</div>
}
