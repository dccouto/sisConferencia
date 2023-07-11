import { DescUsuarioMobile } from '../Header/components/DescUsuarioMobile'
import { ResponsiveDrawer } from './components/ResponsiveDrawer'
import { MenuList } from './MenuList'

export function Drawer() {
    return (
        <ResponsiveDrawer>
            <DescUsuarioMobile />
            <MenuList />
        </ResponsiveDrawer>
    )
}
