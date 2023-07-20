import { Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Typography } from '@mui/material'
import EditIcon from '@mui/icons-material/Edit'
import DeleteIcon from '@mui/icons-material/Delete'
import { Box, Grid, Paper } from '@mui/material'

interface ColumnConfig {
    key: string
    displayName: string
    width?: number
    visible?: boolean
}

interface CustomTableProps {
    columnConfig: ColumnConfig[]
    data: any[]
    onEdit: (item: any) => void
    onDelete: (item: any) => void
}

export const CustomTable = ({ columnConfig, data, onEdit, onDelete }: CustomTableProps) => {
    return (
        <Box display={'block'}>
            <Grid container xs={12}>
                <TableContainer component={Paper}>
                    <Table aria-label='simple table'>
                        <TableHead>
                            <TableRow>
                                {columnConfig.map(
                                    (column, key) =>
                                        column.visible !== false && (
                                            <TableCell key={key} sx={{ fontWeight: 'bold' }} width={column.width || ""}>
                                                {column.displayName}
                                            </TableCell>
                                        )
                                )}
                                <TableCell sx={{ fontWeight: 'bold' }} width={100}>{''}</TableCell>
                            </TableRow>
                        </TableHead>

                        {data.length === 0 ? (
                            <Typography textAlign={'center'} p={2}>
                                Nenhuma tipo de evento adicionado
                            </Typography>
                        ) : (
                            <TableBody>
                                {data.map((item, key) => (
                                    <TableRow key={key}>
                                        {columnConfig.map(
                                            (column) =>
                                                column.visible !== false && (
                                                    <TableCell key={column.key} scope='row'>
                                                        {item[column.key]}
                                                    </TableCell>
                                                )
                                        )}
                                        <TableCell>
                                            <EditIcon color='primary' onClick={() => onEdit(item)} />
                                            <span style={{ marginRight: '8px' }} />
                                            <DeleteIcon color='primary' onClick={() => onDelete(item)} />
                                        </TableCell>
                                    </TableRow>
                                ))}
                            </TableBody>
                        )}
                    </Table>
                </TableContainer>
            </Grid>
        </Box>
    )
}

export default CustomTable
