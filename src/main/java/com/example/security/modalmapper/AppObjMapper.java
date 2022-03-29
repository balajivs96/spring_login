package com.example.security.modalmapper;

public interface AppObjMapper<V, D> {
	V mapDomainToDto(D obj);

	D mapDtoToDomain(V obj);
}