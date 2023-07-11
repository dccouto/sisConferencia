import React from 'react'
import { Grid, Typography } from '@mui/material'
import { AccountCircle } from '@mui/icons-material'
import ArrowBackIosNewIcon from '@mui/icons-material/ArrowBackIosNew'
// Store
import { useAuth } from '../../../../hooks/useAuth'
import { useDrawer } from '../../Drawer/hooks/useDrawer'

const DescUsuarioMobile = () => {
    const { auth } = useAuth()

    const { handleCloseDrawer, isDesktop } = useDrawer()

    if (!auth.autenticado || isDesktop) return null

    return (
        <div style={{ backgroundColor: '#1351B4', height: 140, padding: 15, margin: 0 }}>
            <Grid container spacing={2} style={{ marginBottom: 20 }} justifyContent={'center'}>
                <Grid item xs={9}>
                    <Typography variant='h6' sx={{ fontSize: 16 }} color='white'>
                        SISCONFERÊNCIA
                    </Typography>
                </Grid>
                <Grid item container xs={3} justifyContent={'flex-end'}>
                    <ArrowBackIosNewIcon onClick={handleCloseDrawer} style={{ fontSize: 20, color: '#FFF' }} />
                </Grid>
            </Grid>

            <Grid item container gap={2}>
                <AccountCircle sx={{ fontSize: 45, color: '#fff' }} />

                <Grid item>
                    <Typography variant='h6' sx={{ fontSize: 14 }} color='white'>
                        {auth.name}
                    </Typography>
                    <Typography variant='h6' sx={{ fontSize: 12 }} color='white'>
                        {auth.cpf} - {auth.perfil}
                    </Typography>
                    <Typography sx={{ fontSize: 12 }} color='white'>
                        {auth.ibge} - {auth.unidades.length > 0 ? auth.unidades[0] : ''}
                    </Typography>
                </Grid>
            </Grid>
        </div>
    )
}

export { DescUsuarioMobile }
