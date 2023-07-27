package br.gov.mds.sisConferencia.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import br.gov.mds.sisConferencia.models.Orgao;
import br.gov.mds.sisConferencia.repository.OrgaoRepository;
import br.gov.mds.sisConferencia.service.dto.OrgaoDTO;
import br.gov.mds.sisConferencia.service.mapper.OrgaoMapper;


@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class OrgaoServiceTest {

    @Mock
    private OrgaoRepository repositoryMock;

    @Mock
    private OrgaoMapper mapperMock;

    @Spy
    @InjectMocks
    private OrgaoService orgaoService;


    @Test
    void testAtualizar() {
        Long id = 1L;
        Orgao existingOrgao = new Orgao();
        when(repositoryMock.findById(id)).thenReturn(Optional.of(existingOrgao));

        Orgao orgaoAtualizado = new Orgao();
        orgaoAtualizado.setNome("Novo Nome");

        when(repositoryMock.save(existingOrgao)).thenReturn(existingOrgao);

        Orgao result = orgaoService.atualizar(id, orgaoAtualizado);

        assertNotNull(result);
        assertEquals(existingOrgao, result);
        assertEquals(orgaoAtualizado.getNome(), result.getNome());

        verify(repositoryMock, times(1)).findById(id);
        verify(repositoryMock, times(1)).save(existingOrgao);
    }


    @Test
    void testSaveDTO() {
        OrgaoDTO dto = new OrgaoDTO();
        Orgao orgao = new Orgao();

        when(mapperMock.toEntity(dto)).thenReturn(orgao);
        when(repositoryMock.save(orgao)).thenReturn(orgao);
        when(mapperMock.toDto(orgao)).thenReturn(dto);

        OrgaoDTO result = orgaoService.saveDTO(dto);

        assertNotNull(result);
        assertEquals(dto, result);
        verify(mapperMock, times(1)).toEntity(dto);
        verify(repositoryMock, times(1)).save(orgao);
        verify(mapperMock, times(1)).toDto(orgao);
    }


}

