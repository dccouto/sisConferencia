import { useEffect, useState } from 'react'
import { NavItem } from '../NavItem'
import { Collapse, List, ListItemButton, ListItemText } from '@mui/material'
import ExpandMoreIcon from '@mui/icons-material/ExpandMore'
import ExpandLessIcon from '@mui/icons-material/ExpandLess'
import { useLocation } from 'react-router-dom'

// Types
import { IMenuItem } from '../../../../../types'

interface NavCollapseProps {
    menu: IMenuItem
    level: number
}

export function NavCollapse({ menu, level }: NavCollapseProps) {
    const [open, setOpen] = useState(false)
    const location = useLocation()

    const modulo = location.pathname.split('/')[1]

    const selected = menu.rota === '/' + modulo

    const handleClick = () => {
        setOpen(!open)
    }

    useEffect(() => {
        setOpen(selected)
    }, [selected])

    const menus = menu.submenu?.map((item) => {
        return <NavItem key={item.id} item={item} level={level + 1} />
    })

    return (
        <>
            <ListItemButton
                sx={{
                    mb: 0.5,
                    alignItems: 'center',
                    pl: `${level * 24}px`,
                    '&:before': {
                        content: "''",
                        position: 'absolute',
                        left: `${(level - 1) * 24}px`,
                        top: 0,
                        height: '100%',
                        width: '1px',
                        opacity: 1,
                        background: 'rgba(125, 125, 125, 0.14)',
                    },
                }}
                onClick={handleClick}
                selected={selected}
            >
                <ListItemText primary={menu.menu} />
                {open ? <ExpandLessIcon /> : <ExpandMoreIcon />}
            </ListItemButton>
            <Collapse in={open} timeout='auto' unmountOnExit>
                <List component='div' disablePadding sx={{ position: 'relative' }}>
                    {menus}
                </List>
            </Collapse>
        </>
    )
}
