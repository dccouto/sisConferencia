import { useEffect } from 'react'
import { Link, useLocation } from 'react-router-dom'
import { ListItemButton, ListItemText, Typography } from '@mui/material'
import { useDrawer } from '../../hooks/useDrawer'

// Types
import { IMenuItem } from '../../../../../types'

// Hooks
import { useAuth } from '../../../../../hooks/useAuth'

interface NavItemProps {
    item: IMenuItem
    level?: number
}

export function NavItem({ item, level = 0 }: NavItemProps) {
    const location = useLocation()

    const { setFuncionalidades } = useAuth()

    const { handleCloseDrawer, isDesktop } = useDrawer()

    const paths = location.pathname.split('/')

    const selected = paths.length >= 2 && item.rota === '/' + paths[1] + '/' + paths[2]

    useEffect(() => {
        if (selected) {
            setFuncionalidades(item.funcionalidades)
           
        }
    }, [item.funcionalidades, item.rota, selected, setFuncionalidades])

    return (
        <ListItemButton
            key={item.id}
            component={Link}
            to={item.rota ?? '/'}
            onClick={() => (isDesktop ? null : handleCloseDrawer())}
            sx={{
                pl: `${level * 24}px`,
                '&:before': {
                    content: "''",
                    position: 'absolute',
                    left: `${(level - 1) * 24}px`,
                    top: 0,
                    height: '100%',
                    width: '0px',
                    opacity: 1,
                    background: 'rgba(125, 125, 125, 0.14)',
                },
            }}
        >
            <ListItemText
                primary={
                    <Typography variant={'body1'} fontSize={13} fontWeight={selected ? 'bold' : ''}>
                        <span style={{ whiteSpace: 'pre-line' }}>{item.menu}</span>
                    </Typography>
                }
            />
        </ListItemButton>
    )
}
