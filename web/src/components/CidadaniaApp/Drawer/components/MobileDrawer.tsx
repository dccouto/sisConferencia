import { SwipeableDrawer, useTheme } from '@mui/material'
import { ReactNode } from 'react'
import { useDrawer } from '../hooks/useDrawer'

interface IMobileDrawerProps {
    children: ReactNode
}

export function MobileDrawer({ children }: IMobileDrawerProps) {
    const theme = useTheme()

    const { openedDrawer, handleCloseDrawer, handleOpenDrawer } = useDrawer()

    const iOS = typeof navigator !== 'undefined' && /iPad|iPhone|iPod/.test(navigator.userAgent)

    return (
        <SwipeableDrawer
            disableBackdropTransition={!iOS}
            disableDiscovery={iOS}
            sx={{
                '& .MuiDrawer-paper': {
                    width: '85%',
                    boxShadow: '1px 0 10px 1px rgba(0,0,0,.1)',
                    background: '#fafafa',
                    borderRight: 0,
                    [theme.breakpoints.up('md')]: {
                        position: 'relative',
                    },
                    transition: theme.transitions.create('width', {
                        easing: theme.transitions.easing.sharp,
                        duration: theme.transitions.duration.enteringScreen,
                    }),
                },
            }}
            anchor='left'
            onOpen={handleOpenDrawer}
            onClose={handleCloseDrawer}
            open={openedDrawer}
            ModalProps={{
                keepMounted: true, // Better open performance on mobile.
            }}
        >
            {children}
        </SwipeableDrawer>
    )
}
