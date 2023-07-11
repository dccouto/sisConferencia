import { Typography } from '@mui/material'

export default function Home() {
    return (
        <>
            <Typography>
               Breve descrição do sistema.... 
            </Typography>

                       
            <Typography marginTop={2} marginBottom={2}>
                Link de acesso à Portaria MDS Nº xxx, de xxx de xxx de 2023.
            </Typography>

            <a
                target='_blank'
                href='https://www.in.gov.br/web/dou/-/portaria-mds-n-xxxxxxxx'
                rel='noreferrer'
                style={{ textDecoration: 'none', color: '#1351B4' }}
            >
                https://www.in.gov.br/web/dou/-/portaria-mds-n-886-de-18-de-maio-de-2023-484466703
            </a>
        </>
    )
}
