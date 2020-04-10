package com.example.demo.libraries;

import java.nio.charset.Charset;

/**
 * <p>@Author tomtop 2159</p>
 * <p>@Date 2020/4/9</p>
 * <p>@Version 1.0</p>
 **/
public interface ErpCharset {

    /**
     * Seven-bit ASCII, a.k.a. ISO646-US, a.k.a. the Basic Latin block of the
     * Unicode character set
     */
    Charset US_ASCII = Charset.forName("US-ASCII");

    /**
     * ISO Latin Alphabet No. 1, a.k.a. ISO-LATIN-1
     */
    Charset ISO_8859_1 = Charset.forName("ISO-8859-1");

    /**
     * Eight-bit UCS Transformation Format
     */
    Charset UTF_8 = Charset.forName(Constants.CHARSET_UTF8);

}
