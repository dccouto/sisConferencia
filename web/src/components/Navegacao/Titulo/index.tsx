import { Box, Link as MuiLink, Typography } from '@mui/material'
import ArrowBackIcon from '@mui/icons-material/ArrowBack'
import { useNavigate } from 'react-router-dom'

// Hooks
import { useDrawer } from '../../CidadaniaApp/Drawer/hooks/useDrawer'

interface ITituloProps {
    titulo: string
    voltar?: string
}

export function Titulo({ titulo, voltar }: ITituloProps) {
    const navigate = useNavigate()

    const { isDesktop } = useDrawer()

    return (
        <Box sx={{ my: 3 }} display='flex' justifyContent='space-between'>
            <Typography variant='h6' fontWeight={'bold'} color='#0C326F' >{titulo}</Typography>
            {isDesktop && voltar && (
                <MuiLink
                    sx={{ cursor: 'pointer', display: 'flex', alignItems: 'center' }}
                    underline='hover'
                    color='secondary'
                    onClick={() => navigate(voltar ?? '-1')}
                >
                    <ArrowBackIcon sx={{ fontSize: '15px' }} />
                    &nbsp;Voltar
                </MuiLink>
            )}
        </Box>
    )
}
