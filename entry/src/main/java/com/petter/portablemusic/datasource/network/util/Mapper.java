package com.petter.portablemusic.datasource.network.util;

public interface Mapper<I, O> {
    public O invoke(I input);
}
