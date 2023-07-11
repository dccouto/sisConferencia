import { AppBar, Grid, Toolbar } from '@mui/material'
import { MenuButton } from './components/MenuButton'
import { DescSistema } from './components/DescSistema'
import { DescUsuario } from './components/DescUsuario'
import { useDrawer } from '../Drawer/hooks/useDrawer'

export function Header() {
    const { isDesktop } = useDrawer()

    return (
        <AppBar
            sx={{
                boxShadow: '0 1px 10px 1px rgba(0,0,0,.1)',
                position: 'fixed',
                zIndex: (theme) => (isDesktop ? theme.zIndex.drawer + 1 : theme.zIndex.drawer - 1),
            }}
        >
            <Toolbar>
                <Grid container alignItems='center'>
                    <MenuButton />
                    <Grid item sx={{ flexGrow: 1 }}>
                        <Grid container alignItems='center' justifyContent='space-between'>
                            <DescSistema />
                            <DescUsuario />
                        </Grid>
                    </Grid>
                </Grid>
            </Toolbar>
        </AppBar>
    )
}
