import { Drawer } from '@mui/material'
import { ReactNode } from 'react'
import { useDrawer } from '../hooks/useDrawer'

interface IDesktopDrawerProps {
    children: ReactNode
}

export function DesktopDrawer({ children }: IDesktopDrawerProps) {
    const { openedDrawer, handleCloseDrawer, drawerWidth } = useDrawer()

    return (
        <Drawer
            sx={{
                '& .MuiDrawer-paper': {
                    width: drawerWidth,
                    minHeight: 'calc(100vh - 40px)',
                    boxShadow: '1px 0 10px 1px rgba(0,0,0,.1)',
                    background: '#fafafa',
                    borderRight: 0,
                    boxSizing: 'border-box',
                    flexShrink: 0,
                    whiteSpace: 'nowrap',
                    overflowX: 'hidden',
                    paddingTop: 10,
                },
            }}
            variant='persistent'
            anchor='left'
            onClose={handleCloseDrawer}
            open={openedDrawer}
        >
            {children}
        </Drawer>
    )
}
