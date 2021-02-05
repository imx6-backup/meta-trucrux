#Copyright (c) 2020 Trunexa Inc.

DESCRIPTION = "U-Boot provided by Freescale with focus on  i.MX reference boards."
require recipes-bsp/u-boot/u-boot.inc

PROVIDES += "u-boot"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

#Branch based on nxp/imx_v2016.03_4.1.15_2.0.0_ga branch
SRCBRANCH = "trux-d01-512ram"
SRCREV = "368723946429a999eeaff7f3ab4f31f070979d3e"
SRC_URI = "git://github.com/trucrux/u-boot-trucrux.git;protocol=https;branch=${SRCBRANCH}"


S = "${WORKDIR}/git"

inherit fsl-u-boot-localversion

LOCALVERSION ?= "-${SRCBRANCH}"

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(mx6|mx6ul|mx7|imx6-truxd01)"
