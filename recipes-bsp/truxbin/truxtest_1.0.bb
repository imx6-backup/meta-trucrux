# Copyright (c) 2020 Trunexa Inc.

DESCRIPTION = "truxtest binaries"
PROVIDES += "truxtest"
LICENSE = "GPLv2+"

COMPATIBLE_MACHINE = "(imx6-truxq01)"

LIC_FILES_CHKSUM = "file://GPL-2;md5=46c0115761e5e933d989c523fa9af381"

SRC_URI = "file://tamper \
           file://slide1 \
           file://slide2 \
           file://slide3 \
           file://GPL-2 \
           "
FILES_${PN} = "truxtest"
S = "${WORKDIR}"

do_install() {
    mkdir -p ${D}/truxtest
    install -m 0644 ${S}/tamper ${D}/truxtest
    install -m 0644 ${S}/slide1 ${D}/truxtest
    install -m 0644 ${S}/slide2 ${D}/truxtest
    install -m 0644 ${S}/slide3 ${D}/truxtest
    chmod   +x ${D}/truxtest/*
}

