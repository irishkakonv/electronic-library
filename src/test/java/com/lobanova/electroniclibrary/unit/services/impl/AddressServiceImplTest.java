package com.lobanova.electroniclibrary.unit.services.impl;

import com.lobanova.electroniclibrary.dtos.AddressDto;
import com.lobanova.electroniclibrary.entities.Address;
import com.lobanova.electroniclibrary.repositories.AddressRepository;
import com.lobanova.electroniclibrary.services.impl.AddressServiceImpl;
import com.lobanova.electroniclibrary.utils.AddressUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.core.convert.ConversionService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static com.lobanova.electroniclibrary.utils.AddressUtil.city;
import static com.lobanova.electroniclibrary.utils.AddressUtil.country;
import static com.lobanova.electroniclibrary.utils.AddressUtil.getConvertedAddress;
import static com.lobanova.electroniclibrary.utils.AddressUtil.getInputAddress;
import static com.lobanova.electroniclibrary.utils.AddressUtil.getOutputAddress;
import static com.lobanova.electroniclibrary.utils.AddressUtil.getSavedAddress;
import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
public class AddressServiceImplTest {

    @InjectMocks
    private AddressServiceImpl addressService;
    @Mock
    private AddressRepository addressRepository;
    @Mock
    private ConversionService conversionService;

    @Test
    public void testCreate() {
        AddressDto inputAddress = getInputAddress();
        Address convertedAddress = getConvertedAddress();
        Address savedAddress = getSavedAddress();
        AddressDto outputAddress = getOutputAddress();

        Mockito.when(conversionService.convert(inputAddress, Address.class)).thenReturn(convertedAddress);
        Mockito.when(addressRepository.save(convertedAddress)).thenReturn(savedAddress);
        Mockito.when(conversionService.convert(savedAddress, AddressDto.class)).thenReturn(outputAddress);

        AddressDto result = addressService.create(inputAddress);

        Assert.assertSame(outputAddress, result);
    }

    @Test
    public void testCreate2() {
        AddressDto inputAddress = getInputAddress();
        Address convertedAddress = getConvertedAddress();
        Address savedAddress = getSavedAddress();
        AddressDto outputAddress = getOutputAddress();

        Mockito.when(conversionService.convert(inputAddress, Address.class)).thenReturn(convertedAddress);
        Mockito.when(addressRepository.save(convertedAddress)).thenReturn(savedAddress);
        Mockito.when(conversionService.convert(savedAddress, AddressDto.class)).thenReturn(outputAddress);

        addressService.create(inputAddress);

        Mockito.verify(conversionService, Mockito.times(1)).convert(inputAddress, Address.class);
        Mockito.verify(addressRepository, Mockito.times(1)).save(convertedAddress);
        Mockito.verify(conversionService, Mockito.times(1)).convert(savedAddress, AddressDto.class);
        Mockito.verify(conversionService, Mockito.times(2)).convert(any(), any());
    }

    @Test
    public void testRead() {
        Address savedAddress = getSavedAddress();
        Optional<Address> savedAddressOptional = Optional.of(savedAddress);
        AddressDto outputAddress = getOutputAddress();

        Mockito.when(addressRepository.findById(Mockito.anyLong())).thenReturn(savedAddressOptional);
        Mockito.when(conversionService.convert(savedAddress, AddressDto.class)).thenReturn(outputAddress);

        AddressDto result = addressService.read(Mockito.anyLong());

        Assert.assertSame(result, outputAddress);
    }

    @Test
    public void testRead2() {
        Address savedAddress = getSavedAddress();
        Optional<Address> savedAddressOptional = Optional.of(savedAddress);
        AddressDto outputAddress = getOutputAddress();

        Mockito.when(addressRepository.findById(Mockito.anyLong())).thenReturn(savedAddressOptional);
        Mockito.when(conversionService.convert(Mockito.any(), Mockito.any())).thenReturn(outputAddress);

        addressService.read(ArgumentMatchers.anyLong());

        Mockito.verify(addressRepository, Mockito.times(1)).findById(Mockito.anyLong());
        Mockito.verify(conversionService, Mockito.times(1)).convert(savedAddress, AddressDto.class);
    }

    @Test(expected = RuntimeException.class)
    public void testRead3() {
        Mockito.when(addressRepository.findById(Mockito.anyLong())).thenThrow(RuntimeException.class);

        addressRepository.findById(Mockito.anyLong());
    }

    @Test
    public void testDelete() {
        Mockito.doNothing().when(addressRepository).deleteById(any());

        addressService.delete(any());

        Mockito.verify(addressRepository, Mockito.times(1)).deleteById(any());
    }

    @Test
    public void testGetAll() {
        Address savedAddress = getSavedAddress();
        Set<Address> savedAddresses = new HashSet<>();
        savedAddresses.add(savedAddress);
        AddressDto outputAddress = getOutputAddress();

        Mockito.when(addressRepository.findAll()).thenReturn(savedAddresses);
        Mockito.when(conversionService.convert(savedAddress, AddressDto.class)).thenReturn(outputAddress);

        Set<AddressDto> result = addressService.getAll();

        Assert.assertSame(result.iterator().next(), outputAddress);
    }

    @Test
    public void testGetAll2() {
        Address savedAddress = getSavedAddress();
        Set<Address> savedAddresses = new HashSet<>();
        savedAddresses.add(savedAddress);
        AddressDto outputAddress = getOutputAddress();

        Mockito.when(addressRepository.findAll()).thenReturn(savedAddresses);
        Mockito.when(conversionService.convert(savedAddress, AddressDto.class)).thenReturn(outputAddress);

        addressService.getAll();

        Mockito.verify(addressRepository, Mockito.times(1)).findAll();
        Mockito.verify(conversionService, Mockito.times(1)).convert(savedAddress, AddressDto.class);
    }

    @Test
    public void testGetOrCreateAddress() {
        Address savedAddress = getSavedAddress();

        Mockito.when(addressRepository.findByCountryAndCity(country, city)).thenReturn(savedAddress);

        Address result = addressService.getOrCreateAddress(country, city);

        Assert.assertSame(result, savedAddress);
    }

    @Test
    public void testGetOrCreateAddress2() {
        Address savedAddress = getSavedAddress();

        Mockito.when(addressRepository.findByCountryAndCity(country, city)).thenReturn(null);
        Mockito.when(addressRepository.save(ArgumentMatchers.any())).thenReturn(savedAddress);

        Address result = addressService.getOrCreateAddress(country, city);

        Assert.assertSame(result, savedAddress);
    }
}
