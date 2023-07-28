import { useEffect, useState } from 'react'
import { FormProvider, useForm } from 'react-hook-form'
import { yupResolver } from '@hookform/resolvers/yup'
import * as yup from 'yup'

import {
    Box,
    Grid,
    Typography,
    TableContainer,
    Table,
    TableHead,
    TableRow,
    TableCell,
    Paper,
    TableBody,
    MenuItem,
} from '@mui/material'

import EditIcon from '@mui/icons-material/Edit'
import SearchIcon from '@mui/icons-material/Search'
import DeleteIcon from '@mui/icons-material/Delete'


import { BotaoPadrao } from '../../../components/Formulario/BotaoPadrao'

import { useToast } from '../../../hooks/useToast'
import Mask from '../../../utils/mask'
import { useNavigate } from 'react-router-dom'
import { IEvento, ITipoEvento } from '../../../services/sisConferenciaApi/eventos/types'
import { IListaEventos } from '../../../services/sisConferenciaApi/eventos/types'
import { RHFSelect } from '../../../components/Formulario/reactHookForms/RHFSelect'
import apiServiceTipoEvento from '../../../services/sisConferenciaApi/tipoEvento'
import { RHFDate } from '../../../components/Formulario/reactHookForms/RHFDate'


interface ColumnConfig {
    key: string
    displayName: string
    width?: number
    visible?: boolean
}



const EventosFiltro = () => {
    const navigate = useNavigate()
    const [tiposEvento, setTiposEvento] = useState<ITipoEvento[]>([]);
    const [listaNomeEventos, setListaNomeEventos] = useState<IListaEventos>([]);
    const [visible,setVisible] = useState(true)
    const [eventos,setEventos] = useState<IListaEventos | []> ([])

    const { toastSuccess, toastError } = useToast()


    const columnConfig= [
        { key: 'tipoEvento', displayName: 'Tipo de Evento', visible: true },
        { key: 'nome', displayName: 'Nome', width: 300, visible: true },
        { key: 'tema', displayName: 'Tema', visible: true },
        { key: 'dataFinal', displayName: 'Data Final', visible: true },
        { key: 'dataInicial', displayName: 'Data Inicial', visible: true },
        { key: 'tipoFormato', displayName: 'Formato do Evento', visible: true },
    ];
    

    const FormSchema = yup.object().shape({
        objetivo: yup
            .string()
            .required('Objetivo é obrigatório *'),
    })

    const rhfmethods = useForm<IListaEventos>({ resolver: yupResolver(FormSchema) })

 
    const handleEditar = (item: IEvento) => {
   
    }





    //Carrega combos
    useEffect(() => {
        const atualizarListaCombos = async () => {
            try {
                const result = await apiServiceTipoEvento.listar();
                if (Array.isArray(result)) {
                    setTiposEvento(result);
                } else {
                    console.error("Erro ao obter Tipo Evento");
                }
            }
            catch(error){
                console.error(error)
            }
        
                
        };

        atualizarListaCombos();
    }, []);


    
    return (
        <>
            <FormProvider {...rhfmethods}>
                {visible && (
                    <>

                    
                    <Grid container spacing={2} my={4} mr={4}  xs={12} >
                        
                        <RHFSelect name='tipoEvento' label='Tipo do Evento' gridProps={{ lg: 2 }}>
                        {tiposEvento.map((tipo) => (
                            <MenuItem key={tipo.id} value={tipo.id}>
                                {tipo.descricao}
                            </MenuItem>
                            ))}
                         </RHFSelect>
                   

                        <RHFSelect name='nomeEventoPesquisa' label='Nome' gridProps={{ lg: 4 }}>
                        {listaNomeEventos.map((evento) => (
                            <MenuItem key={evento.id} value={evento.id}>
                                {evento.nome}
                            </MenuItem>
                            ))}
                         </RHFSelect>

                         <RHFDate
                            name={'dataInicial'}
                            label={'Inicio'}
                            minDate={new Date()}
                            gridProps={{ lg: 2}}
                         />

                        <RHFDate
                            name={'dataFinal'}
                            label={'Fim'}
                            minDate={new Date()}
                            gridProps={{ lg: 2 }}
                        />
                    </Grid>        

                    <Grid container spacing={2} my={4} mr={4} justifyContent={'end'}>
                        <Grid>
                            <BotaoPadrao
                                size={'large'}
                                onClick={() =>{ 
                                navigate('/administracao/eventos/criar')
                            }}>
                            <SearchIcon fontSize='small' style={{ marginRight: 10 }}></SearchIcon>
                            Pesquisar
                            
                        </BotaoPadrao>
                        </Grid>
                    </Grid>

                    
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

                                    {eventos.length === 0 ? (
                                        <Typography textAlign={'center'} p={2}>
                                            Nenhum evento encontrado
                                        </Typography>
                                    ) : (
                                        <TableBody>
                                        {eventos.map((item, key) => (
                                            <TableRow key={key}>
                                                {columnConfig.map((column) => {
                                                if (column.visible !== false) {
                                                    // Se a chave é "tipoEvento", "tipoFormato", etc., renderize a propriedade "descricao" dentro desses objetos
                                                    if (['tipoEvento', 'tipoFormato'].includes(column.key)) {
                                                    return (
                                                        <TableCell key={column.key} scope='row'>
                                                        {(item[column.key as keyof typeof item] as any).descricao}
                                                        </TableCell>
                                                    );
                                                    } else {
                                                    return (
                                                        <TableCell key={column.key} scope='row'>
                                                        {item[column.key as keyof typeof item]}
                                                        </TableCell>
                                                    );
                                                    }
                                                }
                                                return null;
                                                })}
                                                <TableCell>
                                                <EditIcon color='primary' onClick={() => ()=>{}} />
                                                <span style={{ marginRight: '8px' }} />
                                                
                                                </TableCell>
                                            </TableRow>
                                            ))}
                                    </TableBody>
                                    )}
                                </Table>
                            </TableContainer>
                        </Grid>
                    </Box>
                        
                       

                        
                    </>
                )}
            </FormProvider>
        </>
    )
}

export default EventosFiltro
