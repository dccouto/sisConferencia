package br.gov.mds.sisConferencia.job;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class CacheEvictJobTest {

    @Spy
    @InjectMocks
    private CacheEvictJob cacheEvictJob;
    
    @Test
    void executaJobLimpaCacheTest() {
        cacheEvictJob.removeCache();
        verify(cacheEvictJob, times(1)).removeCache();
    }

}
