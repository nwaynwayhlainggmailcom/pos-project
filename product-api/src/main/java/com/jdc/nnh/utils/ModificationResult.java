package com.jdc.nnh.utils;



import lombok.Data;

public record ModificationResult<ID>(
		ID id,
		boolean success,
		String message
		) {

	public static<ID> ModificationResult<ID> success(ID id,String message){
		
		return new ModificationResult<ID>(id, true,message);
	}
	
}