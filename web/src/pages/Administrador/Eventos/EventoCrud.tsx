import { useEffect, useState } from 'react'
import { FormProvider, useForm } from 'react-hook-form'
import { yupResolver } from '@hookform/resolvers/yup'
import * as yup from 'yup'

import {
    Grid,
} from '@mui/material'

import EditIcon from '@mui/icons-material/Edit'
import DeleteIcon from '@mui/icons-material/Delete'


import { BotaoPadrao } from '../../../components/Formulario/BotaoPadrao'

import { useToast } from '../../../hooks/useToast'
import Mask from '../../../utils/mask'
import { useNavigate } from 'react-router-dom'
import { IEvento } from '../../../services/sisConferenciaApi/eventos/types'
import { IListaEventos } from '../../../services/sisConferenciaApi/eventos/types'
import {  DataGrid, ptBR } from '@mui/x-data-grid'
import { format, parseISO } from 'date-fns'


interface ColumnConfig {
    key: string
    displayName: string
    width?: number
    visible?: boolean
}

interface Props {
    visible: boolean
    eventos: IListaEventos
    setEventos: (Eventos: IListaEventos) => void
    apiService:any
    columnConfig: ColumnConfig[]
}



const EventosCrud = ({ visible, eventos, setEventos,apiService,columnConfig }: Props) => {




    const columns = [
        { field: 'id', headerName: 'ID', width: 100},
        { field: 'nome', headerName: 'Nome', flex: 1 },
        { field: 'objetivo', headerName: 'Objetivo', flex: 1  },
        { field: 'dataInicial', headerName: 'Data Inicial', flex: 1,valueGetter: (params : any) =>  format( parseISO(params.row.dataInicial), 'dd/MM/yyyy'),},
        { field: 'dataFinal', headerName: 'Data Final', flex: 1, valueGetter: (params : any) => format( parseISO(params.row.dataFinal),'dd/MM/yyyy'),},
        { field: 'tema', headerName: 'Tema' , flex: 1},
        { field: 'ativo', headerName: 'Ativo', flex: 1 ,valueGetter: (params : any) => params.row.ativo? 'Sim':'Não'},
        { field: 'tipoEvento', headerName: 'Tipo de Evento', flex: 1,valueGetter: (params : any) => params.row.tipoEvento.descricao,},
        { field: 'tipoFormato', headerName: 'Formato do Evento', flex: 1,valueGetter: (params : any) => params.row.tipoFormato.descricao,},
        {
            field: 'actions',
            headerName: 'Ações',
            flex: 1,
            renderCell: (params:  any) => (
              <>
                <EditIcon color='primary' onClick={() =>  navigate('/administracao/eventos/registrar/' + params.row.id)} />
                <span style={{ marginRight: '8px' }} />
                <DeleteIcon color='primary' onClick={() =>deletarEvento(params.row)} />
              </>
            ),
          },
      ];
    



    const navigate = useNavigate()
    const [isForm, setIsForm] = useState(false)
    const [editItem, setEditItem] = useState<IEvento | null>(null)

    const adicionarEventos = (item: IEvento) => {
        const index = eventos.findIndex((evento) => evento.id === item.id)
    
        if (index !== -1) {
            const updatedEventos = [...eventos]
            updatedEventos[index] = item
            setEventos(updatedEventos)
        } else {
            setEventos([...eventos, item])
        }
    }

    const deletarEventos = async (item: IEvento) => {
        const list = eventos.filter((c) => c.id !== item.id)
        await apiService.excluir(item.id)
        setEventos(list)
    }

    const verifyDuplicateDescricao = (txtDescricao: string) => {
        txtDescricao = Mask.numeros(txtDescricao)
        const find = eventos.find((evento) => String(evento.objetivo) === txtDescricao)
        if (find) return false
        return true
    }

    const { toastSuccess, toastError } = useToast()

    const FormSchema = yup.object().shape({
        objetivo: yup
            .string()
            .required('Objetivo é obrigatório *')
            .test('test-descricao', 'Tipo de Evento já cadastrado', (value: any) => {
                return verifyDuplicateDescricao(value)
            }),
    })

    const rhfmethods = useForm<IListaEventos>({ resolver: yupResolver(FormSchema) })

    const handleSalvar = async (values: IEvento) => {
        try {
            let dataSave = {
                id: values.id,
                objetivo: values.objetivo,
            }
            let evento: IEvento

            if (editItem) {
                evento = await apiService.atualizar(dataSave.id, dataSave)
            } else {
                evento = await apiService.criar(dataSave)
            }
            adicionarEventos(evento)
            toastSuccess('Evento adicionado com sucesso.')
            setIsForm(false)
            setEditItem(null)
        } catch (error) {
            console.log(error)
            toastError('Erro ao adicionar Evento')
        }
    }

    const handleEditar = (item: IEvento) => {
   
    }

    
    const deletarEvento = async (item: IEvento) => {
        const list = eventos.filter((c) => c.id !== item.id)
        await apiService.excluir(item.id)
        setEventos(list)
    }
 
    return (
        <>
            <FormProvider {...rhfmethods}>
                {visible && (
                    <>

                        <DataGrid
                           rows={eventos}
                           localeText={ptBR.components.MuiDataGrid.defaultProps.localeText} 
                           columns={columns}
                           initialState={{
                            pagination: {
                              paginationModel: { pageSize: 10, page: 0 },
                            },
                          }}
                        />                       

                        <Grid container spacing={2} my={4} mr={4} justifyContent={'end'}>
                            <Grid>
                                <BotaoPadrao size={'large'} variant='outlined' onClick={() =>{ 
                                    navigate('/administracao/eventos/registrar')
                                }}>
                                ADICIONAR NOVO EVENTO
                            </BotaoPadrao>
                            </Grid>
                        </Grid>
                    </>
                )}
            </FormProvider>
        </>
    )
}

export default EventosCrud
