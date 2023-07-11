import { useEffect, useState } from 'react'
import { Card, CardContent, CardActions, CardHeader, Divider, Typography, Grid } from '@mui/material'
import { useNavigate } from 'react-router-dom'

// Components
import { BotaoPadrao } from '../../../components/Formulario/BotaoPadrao'
import { Breadcrumbs } from '../../../components/Navegacao/Breadcrumbs'
import { Titulo } from '../../../components/Navegacao/Titulo'

// Hooks
import { useDrawer } from '../../../components/CidadaniaApp/Drawer/hooks/useDrawer'

// Store


// Services

import { useAuth } from '../../../hooks/useAuth'

const EventosReunioes = () => {
    const navigate = useNavigate()

    const { isDesktop } = useDrawer()

    const { auth } = useAuth()

    const [loading, setLoading] = useState(false)
    

    const isMunicipal = ['Gestor Municipal'].includes(auth.perfil)

    useEffect(() => {
       
    }, [])

 
    return (
        <>
            <Breadcrumbs
                current={`Reuniões`}
                prevCrumbs={[{ name: 'Página inicial' }, { name: 'Eventos' }]}
            />

            <Titulo titulo={`Reuniões`} voltar={`/`} />

            <Typography mb={3} variant='body1'>
                Nessa página serão listadas as reiões mais recentes cadastradas.
            </Typography>

            <Divider />

            {loading ? (
                <Typography variant='h6' mt={2}>
                    Carregando dados...
                </Typography>
            ) : (
                <Typography variant='h6' mt={2}>
                    {!loading ? 'Requerimentos disponíveis' : 'Nenhum requerimentos disponível'}
                </Typography>
            )}

            <Grid container xs={12} my={3}>
                LISTAR CONFERÊNCIAS MAIS RECENTES
            </Grid>
        </>
    )
}

export default EventosReunioes
