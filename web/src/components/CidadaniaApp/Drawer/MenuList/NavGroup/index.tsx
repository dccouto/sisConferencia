import { Divider, List } from '@mui/material'
import { NavCollapse } from '../NavCollapse'

// Types
import { IMenuItem } from '../../../../../types'

interface NavGroupProps {
    item: IMenuItem
}

export function NavGroup({ item }: NavGroupProps) {
    return (
        <>
            <List>
                <NavCollapse menu={item} level={1} />
            </List>

            <Divider sx={{ mt: 0.25, mb: 1.25 }} />
        </>
    )
}
