package com.sankaran.ssm.admin.mappers;

import java.util.List;

public interface DtoEntityMapper<A, B> {

    default B convert(A source) { throw new UnsupportedOperationException();}

    default List<B> convert(List<A> sourceList) { throw new UnsupportedOperationException(); }

}
