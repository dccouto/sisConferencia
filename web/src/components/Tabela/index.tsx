import { memo, ReactNode } from 'react'

import MUIDataTable, { MUIDataTableColumnDef, MUIDataTableOptions } from 'mui-datatables'
import { useDrawer } from '../CidadaniaApp/Drawer/hooks/useDrawer'
import CircularProgress from '@mui/material/CircularProgress'
import { labelsPt } from './Config/TraducaoPtBr'
import { Box, Typography } from '@mui/material'

interface ITabelaPadraoProps {
    titulo: string
    limit: number
    data: (object | number[] | string[])[]
    columns: MUIDataTableColumnDef[]
    options?: MUIDataTableOptions
    isLoading?: boolean
    titleButtons?: ReactNode
}

function TabelaPadraoComponent({ titulo, limit, data, columns, options, isLoading, titleButtons }: ITabelaPadraoProps) {
    const { isDesktop } = useDrawer()

    const defaultOptions: MUIDataTableOptions = {
        ...labelsPt(isLoading),
        expandableRows: !isDesktop,
        expandableRowsOnClick: true,
        selectableRowsOnClick: false,
        selectableRows: 'none',
        responsive: 'standard',
        tableId: 'id',
        count: data?.length || -1,
        search: false,
        download: false,
        filter: false,
        print: false,
        viewColumns: false,
        rowsPerPage: limit,
        rowsPerPageOptions: isDesktop ? [10, 50, 100] : [10],
    }

    const opt: MUIDataTableOptions = {
        ...defaultOptions,
        ...options,
    }

    return (
        <MUIDataTable
            title={
                <Box display='flex' gap={2} alignItems='center'>
                    <Typography variant='h6'>
                        {titulo}
                        {isLoading && (
                            <CircularProgress
                                color='secondary'
                                size={24}
                                style={{ marginLeft: 15, position: 'relative', top: 4 }}
                            />
                        )}
                    </Typography>
                    {titleButtons}
                </Box>
            }
            data={data}
            columns={columns}
            options={opt}
        />
    )
}

export const Tabela = memo(TabelaPadraoComponent, (prevProps, nextProps) => {
    return prevProps.data === nextProps.data && prevProps.isLoading === nextProps.isLoading
})
