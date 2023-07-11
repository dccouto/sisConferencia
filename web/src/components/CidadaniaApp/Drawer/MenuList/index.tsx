import { NavGroup } from './NavGroup'
import { useAuth } from '../../../../hooks/useAuth'

export function MenuList() {
    const {
        auth: { userMenuItems },
    } = useAuth()

    const navItems = userMenuItems.map((item) => {
        return <NavGroup key={item.id} item={item} />
    })

    return <>{navItems}</>
}
