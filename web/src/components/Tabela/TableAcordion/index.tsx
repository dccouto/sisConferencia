import { Accordion, AccordionDetails, AccordionSummary, Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Typography } from '@mui/material'
import EditIcon from '@mui/icons-material/Edit'
import ExpandMoreIcon from "@mui/icons-material/ExpandMore";
import ExpandLessIcon from "@mui/icons-material/ExpandLess";
import DeleteIcon from '@mui/icons-material/Delete'
import { Box, Grid, Paper } from '@mui/material'
import { useState } from 'react';

export interface AcordionConfig {
    id: number
    AccordionSummary: string
    AccordionDetails: string
    object: any
    icon:string
}

interface CustomTableProps {
    acordionConfig: AcordionConfig[] | null
    data: any[]
    onEdit: (item: any) => void
    onDelete: (item: any) => void
    txtNenhumRegistro: string
}

export const TableAcordion = ({ acordionConfig, data, onEdit, onDelete, txtNenhumRegistro}: CustomTableProps) => {


    const [expanded, setExpanded] = useState<string | false>(false);

    // Função para lidar com a mudança de estado do Accordion
    const handleChange = (panel: string) => (
      event: React.SyntheticEvent,
      newExpanded: boolean
    ) => {
      setExpanded(newExpanded ? panel : false);
    };


    return (
        <Box display={'block'}>
            <Grid container xs={12}>
                <TableContainer component={Paper}>
                    <Table aria-label='simple table'>
                       

                        {data.length === 0 ? (
                            <Typography textAlign={'center'} p={2}>
                                {txtNenhumRegistro} 
                            </Typography>
                        ) : (
                            <TableBody>
                                {acordionConfig?.map((item, key) => (
                                    <TableRow key={key}>
                                        <TableCell>
                                        
                                            <Accordion 
                                            expanded={expanded === `panel${key}`}  // Checamos se este Accordion está expandido
                                            onChange={handleChange(`panel${key}`)}  // Atualizamos o estado quando este Accordion for expandido
                                            >
                                            <AccordionSummary
                                                expandIcon={
                                                expanded === `panel${key}` ? <ExpandLessIcon /> : <ExpandMoreIcon />
                                                }
                                            >
                                                     <Grid  xs={11} >
                                                     {item.id} - {item.AccordionSummary} 
                                                     </Grid>
                                                    <Grid xs={1} >
                                                        <EditIcon color='primary' onClick={() => onEdit(item.object)} />
                                                        <span style={{ marginRight: '10px' }} />
                                                        <DeleteIcon color='primary' onClick={() => onDelete(item.object)} />
                                                    </Grid>
                                                </AccordionSummary>
                                                <AccordionDetails>
                                                    {item.AccordionDetails}
                                                </AccordionDetails>
                                            </Accordion>

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

export default TableAcordion
