import { Footer } from './Footer'
import { styled, Toolbar } from '@mui/material'
import { Header } from './Header'
import { Drawer } from './Drawer'
import { useDrawer } from './Drawer/hooks/useDrawer'
import { AppRoutes } from '../../routes'

const Main = styled('main')<{
    open?: boolean
    drawerwidth?: number
}>(({ theme, open, drawerwidth }) => ({
    flexGrow: 1,
    transition: theme.transitions.create('margin', {
        easing: theme.transitions.easing.sharp,
        duration: theme.transitions.duration.leavingScreen,
    }),
    ...(open && {
        transition: theme.transitions.create('margin', {
            easing: theme.transitions.easing.easeOut,
            duration: theme.transitions.duration.enteringScreen,
        }),
        marginLeft: `${drawerwidth}px`,
    }),
}))

export function CidadaniaApp() {
    const { openedDrawer, isDesktop, drawerWidth } = useDrawer()

    return (
        <>
            <Drawer />
            <Header />
            <Toolbar />
            <Main
                open={(isDesktop && openedDrawer) || false}
                drawerwidth={drawerWidth}
                sx={{
                    bgcolor: (theme) => theme.palette.background.default,
                    py: 2,
                    px: 3,
                    display: 'flex',
                    flexDirection: 'column',
                    minHeight: `calc(100vh - 40px - 95px)`,
                    // '@media (min-width: 0px) and (orientation: landscape)': {
                    //     minHeight: 'calc(100vh - 40px - 60px)',
                    // },
                    // '@media (min-width: 600px)': {
                    //     minHeight: 'calc(100vh - 40px - 80px)',
                    // },
                }}
            >
                <AppRoutes />
            </Main>
            <Footer />
        </>
    )
}
