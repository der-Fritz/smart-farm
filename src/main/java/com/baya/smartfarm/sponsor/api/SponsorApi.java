package com.baya.smartfarm.sponsor.api;

import com.baya.smartfarm.common.ApiResponse;
import com.baya.smartfarm.common.CrudApi;
import com.baya.smartfarm.common.PaginationResult;
import com.baya.smartfarm.config.TypeMapper;
import com.baya.smartfarm.sponsor.Sponsor;
import com.baya.smartfarm.sponsor.SponsorDto;
import com.baya.smartfarm.sponsor.service.SponsorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/sponsor")
public class SponsorApi implements CrudApi<SponsorDto> {

    private final SponsorService sponsorService;
    private final TypeMapper mapper;

    @PostMapping(value = "/register")
    public ApiResponse<SponsorDto> register(SponsorDto sponsorDto) {
        log.info("New sponsor registration: {}", sponsorDto);
        Sponsor sponsor = sponsorService.register(mapper.map(sponsorDto));
        return new ApiResponse<>(HttpStatus.OK.value(), mapper.map(sponsor));
    }

    @Override
    public ApiResponse<SponsorDto> create(SponsorDto sponsorDto) {
        log.info("New sponsor registration: {}", sponsorDto);
        Sponsor sponsor = sponsorService.register(mapper.map(sponsorDto));
        return new ApiResponse<>(HttpStatus.OK.value(), mapper.map(sponsor));
    }

    @Override
    public ApiResponse<SponsorDto> update(SponsorDto sponsorDto) {
        log.info("Updating existing sponsor: {}", sponsorDto);
        Sponsor sponsor = sponsorService.register(mapper.map(sponsorDto));
        return new ApiResponse<>(HttpStatus.OK.value(), mapper.map(sponsor));
    }

    @Override
    public ApiResponse<SponsorDto> delete(SponsorDto sponsorDto) {
        return null;
    }

    @Override
    public ApiResponse<PaginationResult<SponsorDto>> findAll(String search, Integer page, Integer size, String sortBy) {
        return null;
    }

    @Override
    public ApiResponse<SponsorDto> find(Long id) {
        return null;
    }
}
