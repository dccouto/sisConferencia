
import { useEffect, useState } from 'react'
import { Titulo } from '../../../../components/Navegacao/Titulo'
import { Breadcrumbs } from '../../../../components/Navegacao/Breadcrumbs'


import { Box, Divider, FormControlLabel, Grid, MenuItem, Radio, RadioGroup, TextField, Typography } from '@mui/material'
import ArrowBackIcon from '@mui/icons-material/ArrowBack'
import AddCircleOutlineIcon from '@mui/icons-material/AddCircleOutline'
import DeleteIcon from '@mui/icons-material/Delete'

import { FormProvider, useForm } from 'react-hook-form'
import { IEvento, ITipoEvento } from '../../../../services/sisConferenciaApi/eventos/types'
import { yupResolver } from '@hookform/resolvers/yup'
import * as yup from 'yup'
import { useDrawer } from '../../../../components/CidadaniaApp/Drawer/hooks/useDrawer'
import { BotaoPadrao } from '../../../../components/Formulario/BotaoPadrao'
import { useNavigate } from 'react-router-dom'
import { FormContainer } from '../../../../components/Formulario/FormContainer'
import { RHFText } from '../../../../components/Formulario/reactHookForms/RHFText'
import { RHFSelect } from '../../../../components/Formulario/reactHookForms/RHFSelect'
import RHFTextArea from '../../../../components/Formulario/TextArea'
import { RHFDate } from '../../../../components/Formulario/reactHookForms/RHFDate'
import RHFInputFile from '../../../../components/Formulario/InputFile'
import apiServiceTipoEvento from '../../../../services/sisConferenciaApi/tipoEvento'

const CriarEvento = () => {

    const { isDesktop } = useDrawer()
    const navigate = useNavigate()
    
    const FormSchema = yup.object().shape({
         nome: yup.string().required('Campo de preenchimento obrigatório *'),   
         formato: yup.string().required('Campo de preenchimento obrigatório *'),  
         tipoEvento: yup.string().required('Campo de preenchimento obrigatório *'),  
         dataInicial: yup.string().required('Campo de preenchimento obrigatório *'),  
         dataFinal: yup.string().required('Campo de preenchimento obrigatório *'),  

    });

    const [excluir, setExcluir] = useState(false)

    const rhfmethods = useForm<IEvento>({ resolver: yupResolver(FormSchema) })

    const paginaEventos = '/administracao/eventos'

    const gridStyle = {
        boxShadow: '2px 0px 10px #00000029'
    };

   

    const [tiposEvento, setTiposEvento] = useState<ITipoEvento[]>([]);

    useEffect(() => {
        const fetchTiposEvento = async () => {
            const result = await apiServiceTipoEvento.listar();
                if (Array.isArray(result)) {
                    setTiposEvento(result);
                } else {
                    console.error("Result is not an array");
                }
        };

        fetchTiposEvento();
    }, []);

    function handleSalvar(){

    }

    function umAnoAtras() {
        const year = new Date().getFullYear()
        const month = new Date().getMonth()
        const day = new Date().getDate()
        const date = new Date(year - 1, month, day)
        return date
    }

    return (
        <>
            <Breadcrumbs
                current={`Cadastrar Evento`}
                prevCrumbs={[{ name: 'Administração' },{ name: 'Eventos' }]}
            />
            <Grid padding={2}>
              <Grid style={gridStyle} padding={2}>

                 <Grid   paddingLeft={2} paddingRight={2} paddingTop={1} paddingBottom={1}>
                    <Titulo titulo={`Cadastrar Evento`} voltar={paginaEventos} />
                 </Grid>
           

                <FormProvider {...rhfmethods}>

             
                    <FormContainer>
                    <Grid  padding={2} item xs={12}>
                            <FormContainer>
                                <RHFText
                                    name={'nome'}
                                    label={'Nome'}
                                    gridProps={{ lg: 12}}
                                    inputProps={{ maxLength: 100 }}
                                    InputLabelProps={{ shrink: true }}
                                    onChange={(e) => {
                                        const v = e.target.value
                                        rhfmethods.setValue('nome', v)
                                    }}
                                />

                               <RHFSelect name='tipoEvento' label='Tipo do Evento' gridProps={{ lg: 6 }}>
                                    {tiposEvento.map((tipo) => (
                                        <MenuItem key={tipo.id} value={tipo.id}>
                                            {tipo.descricao}
                                        </MenuItem>
                                    ))}
                                </RHFSelect>
                                
                                <RHFSelect name='formato' label='Formato do Evento' gridProps={{ lg:6 }}>
                                    <MenuItem value={'federal'}>Presencial</MenuItem> 
                                    <MenuItem value={'municipal'}>Virtual</MenuItem>
                                    <MenuItem value={'estadual'}>Mista</MenuItem> 
                                </RHFSelect>
                             
                             </FormContainer>
                        </Grid>   

                        <Grid padding={2} item xs={12}>

                             <Titulo titulo={`Período`} />
                             <FormContainer>
                                <RHFDate
                                    name={'dataInicial'}
                                    label={'Inicio'}
                                    minDate={umAnoAtras()}
                                    maxDate={new Date()}
                                    gridProps={{ lg: 6 }}
                                />

                                <RHFDate
                                    name={'dataFinal'}
                                    label={'Fim'}
                                    gridProps={{ lg: 6 }}
                                />
                            </FormContainer>
                        </Grid>

                        <Grid  padding={2} item xs={12}>

                            <Titulo titulo={`Portaría`} />
                            <FormContainer>
                                    <RHFSelect name='portaria' label='Portaria' gridProps={{ lg:12 }}>
                                        {/* <MenuItem value={'federal'}>Federal</MenuItem> */}
                                        <MenuItem value={'municipal'}>Municipal</MenuItem>
                                        {/* <MenuItem value={'estadual'}>Estadual</MenuItem> */}
                                    </RHFSelect>
                            </FormContainer>
                        </Grid>

                        <Grid  padding={2} item xs={12}>
                            <Titulo titulo={`Outras informações`} />
                            <FormContainer>
                                <RHFText
                                    name={'tema'}
                                    label={'Tema'}
                                    gridProps={{ lg: 6}}
                                    inputProps={{ maxLength: 100 }}
                                    InputLabelProps={{ shrink: true }}
                                    onChange={(e) => {
                                        const v = e.target.value
                                        rhfmethods.setValue('tema', v)
                                    }}
                                />

                            

                                <RHFSelect name='tipoRegime' label='Tipo Regime' gridProps={{ lg: 6 }}>
                                    {/* <MenuItem value={'federal'}>Federal</MenuItem> */}
                                    <MenuItem value={'municipal'}>Municipal</MenuItem>
                                    {/* <MenuItem value={'estadual'}>Estadual</MenuItem> */}
                                </RHFSelect>
                            
                                <RHFTextArea 
                                    name="objetivo"
                                    label="Objetivo"
                                    control={rhfmethods.control as any} // passando o 'control' para o RHFTextArea
                                    rules={{ required: true }}
                                    defaultValue=""
                                    rows={4}
                                    gridProps={{ lg: 12 }}
                                    onChange={(e) => {
                                        const v = e.target.value
                                        rhfmethods.setValue('objetivo', v)
                                    }}
                                />



                                <Grid  padding={2} item xs={12}>

                                <Titulo titulo={`Imagem`} />

                                    <RHFInputFile 
                                        name="myFile" 
                                        label="" 
                                        control={rhfmethods.control as any} 
                                        gridProps={{ lg: 12 }}
                                    />

                                </Grid>

                                <Grid  padding={2} item xs={12}>

                                <Titulo titulo={`Status`} />
                                    <FormContainer>
                                            <RadioGroup >
                                                <FormControlLabel value="option1" control={<Radio />} label="Ativo" />
                                                <FormControlLabel value="option2" control={<Radio />} label="Inativo" />
                                            </RadioGroup>
                                    </FormContainer>
                                </Grid>
                                
                            </FormContainer>
                        </Grid>                    

                      


                    </FormContainer>
                


                    <Grid
                        item
                        xs={12}
                        style={{
                            display: isDesktop ? 'flex' : 'block',
                            justifyContent: 'end',
                            alignItems: 'end',
                        }}
                    >
                        <BotaoPadrao
                            variant='outlined'
                            size={'large'}
                            onClick={() => navigate('/gestao/emergencia/listar')}
                            startIcon={<ArrowBackIcon fontSize='small' />}
                        >
                            Voltar para lista
                        </BotaoPadrao>

                        { true //id
                        && (
                            <BotaoPadrao
                                color='error'
                                variant='outlined'
                                type='button'
                                size={'large'}
                                onClick={() => setExcluir(true)}
                                startIcon={<DeleteIcon fontSize='small' />}
                                style={{
                                    marginTop: isDesktop ? 0 : 10,
                                    marginLeft: isDesktop ? 10 : 0,
                                }}
                            >
                                Excluir
                            </BotaoPadrao>
                        )}

                        <BotaoPadrao
                            size={'large'}
                            type='submit'
                            onClick={rhfmethods.handleSubmit(handleSalvar)}
                            style={{
                                marginTop: isDesktop ? 0 : 10,
                                marginLeft: isDesktop ? 10 : 0,
                            }}
                        >
                            <AddCircleOutlineIcon fontSize='small' style={{ marginRight: 10 }} />
                            { false //id 
                            ? 'Salvar Evento' : 'Criar Evento'}
                        </BotaoPadrao>
                    </Grid>
                </FormProvider>


            </Grid>
            </Grid>
        </>
    )
}



export default CriarEvento