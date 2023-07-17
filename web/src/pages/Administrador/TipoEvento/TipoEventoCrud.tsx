import { useEffect, useMemo, useState } from 'react'
import { FormProvider, useForm } from 'react-hook-form'
import { yupResolver } from '@hookform/resolvers/yup'
import * as yup from 'yup'

// Meterial
import {
    Box,
    Dialog,
    DialogTitle,
    DialogContent,
    FormControlLabel,
    Grid,
    Paper,
    RadioGroup,
    Radio,
    Table,
    TableBody,
    TableCell,
    TableContainer,
    TableHead,
    TableRow,
    Typography,
} from '@mui/material'

// Types
import { ITipoEvento } from '../../../services/sisConferenciaApi/tipoEvento/types'

// Components
import { RHFText } from '../../../components/Formulario/reactHookForms/RHFText'
import { BotaoPadrao } from '../../../components/Formulario/BotaoPadrao'
import DeleteIcon from '@mui/icons-material/Delete'
import EditIcon from '@mui/icons-material/Edit';

// Service
import apiService from './../../../services/sisConferenciaApi/tipoEvento/index';

// Utils
import { useToast } from '../../../hooks/useToast'
import Mask from '../../../utils/mask'
import { useNavigate } from 'react-router-dom'
import { AxiosResponse } from 'axios'

interface Props {
    visible: boolean
    tipoEventos: ITipoEvento[]
    setTipoEventos: (tipoEventos: ITipoEvento[]) => void
}

const TipoEventoCrud = ({ visible, tipoEventos, setTipoEventos }: Props) => {
    const navigate = useNavigate()
    const [isForm, setIsForm] = useState(false)
    const [editItem, setEditItem] = useState<ITipoEvento | null>(null)

    const adicionarTipoEvento = (item: ITipoEvento) => {
        const index = tipoEventos.findIndex((tipoEvento) => tipoEvento.id === item.id);
    
        if (index !== -1) {
            const updatedTipoEventos = [...tipoEventos];
            updatedTipoEventos[index] = item;
            setTipoEventos(updatedTipoEventos);
        } else {
            setTipoEventos([...tipoEventos, item]);
        }
    };

    const deletarTipoEvento = async (item: ITipoEvento) => {
        const list = tipoEventos.filter((c) => c.id !== item.id)
        await apiService.tipoEventoExcluir(item.id)
        setTipoEventos(list)
    }

    const verifyDuplicateDescricao = (txtDescricao: string) => {
        txtDescricao = Mask.numeros(txtDescricao)
        const find = tipoEventos.find((tipoEvento) => String(tipoEvento.descricao) === txtDescricao)

        if (find) return false
        return true
    }

    const { toastSuccess, toastError } = useToast()

    const FormSchema = yup.object().shape({
        descricao: yup
            .string()
            .required('Descrição é obrigatório *')
            .test('test-descricao', 'Tipo de Evento já cadastrado', (value: any) => {
                return verifyDuplicateDescricao(value)
            }),
    })

    const rhfmethods = useForm<ITipoEvento>({ resolver: yupResolver(FormSchema) })

    useEffect(() => {
        rhfmethods.reset()
    }, [isForm])

    const handleSalvar = async (values: ITipoEvento) => {
        try {
            let dataSave = {
                id: values.id,
                descricao: values.descricao,
            }
            let tipoEvento: ITipoEvento

            if (editItem) {
                tipoEvento = await apiService.tipoEventoAtualizar(dataSave.id,dataSave)
            } else {
                tipoEvento = await apiService.tipoEventoCriar(dataSave)
            
            }
            adicionarTipoEvento(tipoEvento)
            

            toastSuccess('Tipo de Evento adicionado com sucesso.')

            setIsForm(false)
            setEditItem(null)
        } catch (error) {
            console.log(error)
            toastError('Erro ao adicionar tipo de Evento')
        }
    }

    const handleEditar = (item: ITipoEvento) => {
        setIsForm(true)
        setEditItem(item)
        rhfmethods.reset(item)
    }

    return (
        <>
            <FormProvider {...rhfmethods}>
                {visible && (
                    <>
                        {/* Tabela */}
                        <Box display={isForm ? 'none' : 'block'}>
                            <Grid container xs={12}>
                                <TableContainer component={Paper}>
                                    <Table aria-label='simple table'>
                                        <TableHead>
                                            <TableRow>
                                                <TableCell sx={{ fontWeight: 'bold' }} width={300}>
                                                    ID
                                                </TableCell>
                                                <TableCell sx={{ fontWeight: 'bold' }}>Descrição</TableCell>
                                                <TableCell sx={{ fontWeight: 'bold' }} width={100}>
                                                    {''}
                                                </TableCell>
                                            </TableRow>
                                        </TableHead>

                                        {tipoEventos.length === 0 ? (
                                            <Typography textAlign={'center'} p={2}>
                                                Nenhuma tipo de evento adicionado
                                            </Typography>
                                        ) : (
                                            <TableBody>
                                                {tipoEventos.map((item, key) => (
                                                    <TableRow key={key}>
                                                        <TableCell scope='row'>{item.id}</TableCell>
                                                        <TableCell>{item.descricao}</TableCell>

                                                        <TableCell>
                                                            <EditIcon
                                                                color='primary'
                                                                onClick={() => handleEditar(item)}
                                                            />

                                                            <span style={{ marginRight: '8px' }} />

                                                            <DeleteIcon
                                                                color={'primary'}
                                                                onClick={() => {
                                                                    deletarTipoEvento(item)
                                                                }}
                                                            />
                                                        </TableCell>
                                                    </TableRow>
                                                ))}
                                            </TableBody>
                                        )}
                                    </Table>
                                </TableContainer>
                            </Grid>
                        </Box>

                        <Dialog {...rhfmethods} open={isForm} onClose={() => setIsForm(false)}>
                            <DialogTitle>Cadastrar Tipo de Evento</DialogTitle>
                            <DialogContent>
                                <Grid container xs={12} spacing={3} mt={1}>
                                    <RHFText
                                        name={'descricao'}
                                        label={'Descrição'}
                                        gridProps={{ xs: 12 }}
                                        inputProps={{ maxLength: 100 }}
                                        InputLabelProps={{ shrink: true }}
                                        onChange={(e) => {
                                            const v = e.target.value
                                            rhfmethods.setValue('descricao', v)
                                        }}
                                    />
                                </Grid>

                                <Grid container justifyContent={'end'} mt={2}>
                                    <Grid>
                                        <BotaoPadrao
                                            variant='outlined'
                                            onClick={() => setIsForm(false)}
                                            sx={{ p: 2 }}
                                            style={{ height: 50 }}
                                        >
                                            Cancelar
                                        </BotaoPadrao>
                                    </Grid>
                                    <Grid ml={2}>
                                        <BotaoPadrao
                                            type='button'
                                            onClick={rhfmethods.handleSubmit(handleSalvar)}
                                            style={{ height: 50 }}
                                            sx={{ p: 2 }}
                                        >
                                            Salvar Tipo de Evento
                                        </BotaoPadrao>
                                    </Grid>
                                </Grid>
                            </DialogContent>
                        </Dialog>

                        <Grid container spacing={2} my={4} mr={4} justifyContent={'end'}>
                            <Grid mr={3}>
                                <BotaoPadrao size={'large'} variant='outlined' onClick={() => setIsForm(true)}>
                                    ADICIONAR NOVO TIPO DE EVENTO
                                </BotaoPadrao>
                            </Grid>
                        </Grid>
                    </>
                )}
            </FormProvider>
        </>
    )
}



export default TipoEventoCrud