import { createContext, ReactNode, useContext, useEffect, useState } from 'react'
import { useMediaQuery } from '@mui/material'
import { useAuth } from '../../../../hooks/useAuth'

interface IDrawerProviderProps {
    children: ReactNode
}

type DrawerContextData = {
    openedDrawer: boolean
    handleOpenDrawer: () => void
    handleCloseDrawer: () => void
    isDesktop: boolean
    drawerWidth: number
}

const DrawerContext = createContext({} as DrawerContextData)

export function DrawerProvider({ children }: IDrawerProviderProps) {
    const [openedDrawer, setOpenedDrawer] = useState(false)

    const isDesktop = useMediaQuery('(min-width:600px)')

    const drawerWidth = 250

    const {
        auth: { autenticado },
    } = useAuth()

    useEffect(() => {
        setOpenedDrawer(!!autenticado)
    }, [autenticado])

    function handleOpenDrawer() {
        setOpenedDrawer(true)
    }

    function handleCloseDrawer() {
        setOpenedDrawer(false)
    }

    return (
        <DrawerContext.Provider
            value={{
                openedDrawer,
                handleCloseDrawer,
                handleOpenDrawer,
                isDesktop,
                drawerWidth,
            }}
        >
            {children}
        </DrawerContext.Provider>
    )
}

export const useDrawer = () => useContext(DrawerContext)
