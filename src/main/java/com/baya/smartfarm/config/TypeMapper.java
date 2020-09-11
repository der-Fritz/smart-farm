package com.baya.smartfarm.config;

import com.baya.smartfarm.farm.Department;
import com.baya.smartfarm.farm.DepartmentDto;
import com.baya.smartfarm.farmer.Farmer;
import com.baya.smartfarm.farmer.FarmerDto;
import com.baya.smartfarm.inputs.ProjectInputs;
import com.baya.smartfarm.inputs.ProjectInputsDto;
import com.baya.smartfarm.location.District;
import com.baya.smartfarm.location.DistrictDto;
import com.baya.smartfarm.location.Province;
import com.baya.smartfarm.location.ProvinceDto;
import com.baya.smartfarm.merchant.Supplier;
import com.baya.smartfarm.merchant.SupplierDto;
import com.baya.smartfarm.product.Product;
import com.baya.smartfarm.product.ProductDto;
import com.baya.smartfarm.project.Manager;
import com.baya.smartfarm.project.ManagerDto;
import com.baya.smartfarm.sponsor.Sponsor;
import com.baya.smartfarm.sponsor.SponsorDto;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface TypeMapper {


  Farmer map(FarmerDto farmerDto);

  FarmerDto map(Farmer farmer);

    Department map(DepartmentDto departmentDto);

    DepartmentDto map(Department department);

    Province map(ProvinceDto provinceDto);

    ProvinceDto map(Province province);

    District map(DistrictDto districtDto);

    DistrictDto map(District district);

    ProjectInputs map(ProjectInputsDto projectInputsDto);

    ProjectInputsDto map(ProjectInputs projectInputs);

    Supplier map(SupplierDto supplierDto);

    SupplierDto map(Supplier supplier);

    Product map(ProductDto productDto);

    ProductDto map(Product product);

    Sponsor map(SponsorDto sponsorDto);

    SponsorDto map(Sponsor sponsor);

    Manager map(ManagerDto managerDto);

    ManagerDto map(Manager manager);
}

