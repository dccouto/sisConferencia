import { useEffect } from 'react'
import { useSearchParams } from 'react-router-dom'
import { Box, Typography } from '@mui/material'
import CircularProgress from '@mui/material/CircularProgress'
import CheckOutlinedIcon from '@mui/icons-material/CheckOutlined'
import { useAuth } from '../../../hooks/useAuth'

/*
 * Página de redirecionamento quando o usuário faz o login no govbr
 * Aqui vamos fazer a requisição para buscar os dados do usuário (cpf, nome, token)
 * E depois fazer a requisição para o backend para fazer as validações e pegar o Perfil
 * E então redireicionar para a home de usuário autenticado
 * */

export default function LoginProcess() {
    const [searchParams] = useSearchParams()

    const {
        auth: { autenticado },
    } = useAuth()

    const code = searchParams.get('code')

    useEffect(() => {
        if (code) {
            // login(code);
        }
    }, [code])

    return (
        <Box>
            <Typography variant={'h5'} mb={2}>
            {!autenticado ? 
            <>Aguarde um momento enquanto processamos a autenticação... </>:
            <>Bem vindo ao SisConferência ! </>}
                
            </Typography>

            {!autenticado ? <CircularProgress size={22} /> : <CheckOutlinedIcon color={'success'} />}
        </Box>
    )
}
