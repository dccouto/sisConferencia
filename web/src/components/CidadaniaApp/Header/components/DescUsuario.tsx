import { Grid, Typography } from '@mui/material'
import { AccountCircle } from '@mui/icons-material'

// Components
import { LogoutButton } from './LogoutButton'

// Hooks
import { useDrawer } from '../../Drawer/hooks/useDrawer'

// Store
import { useAuth } from '../../../../hooks/useAuth'

const DescUsuario = () => {
    const { auth } = useAuth()

    const { isDesktop } = useDrawer()

    if (!auth.autenticado || !isDesktop) return null

    return (
        <div style={{ display: 'flex', flexDirection: 'row', alignItems: 'center' }}>
            <div style={{ marginRight: 20 }}>
                <Grid item container gap={2}>
                    <AccountCircle sx={{ fontSize: 45 }} color='secondary' />

                    <Grid item>
                        <Typography variant='h6' sx={{ fontSize: 12 }} color='secondary'>
                            {auth.name}
                        </Typography>
                        <Typography sx={{ fontSize: 10 }} color='secondary'>
                            Perfil: {auth.perfil}
                        </Typography>
                    </Grid>
                </Grid>
            </div>
            <LogoutButton />
        </div>
    )
}

export { DescUsuario }
