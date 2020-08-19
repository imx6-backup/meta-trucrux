#Copyright (c) 2020 Trunexa Inc.

DESCRIPTION = "U-Boot provided by Freescale with focus on  i.MX reference boards."
require recipes-bsp/u-boot/u-boot.inc

PROVIDES += "u-boot"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

#SRCBRANCH = "nxp/imx_v2016.03_4.1.15_2.0.0_ga"
#SRCREV = "a57b13b942d59719e3621179e98bd8a0ab235088"
#SRC_URI = "git://source.codeaurora.org/external/imx/uboot-imx.git;protocol=https;branch=${SRCBRANCH} \
# 	       file://0001-PATCH001-TRUX-iMX6UL-Q01-Linux4.1.15-V.2.0.0_UBoot_basic_customisation.patch" 

SRCBRANCH = "trux-q01"
SRCREV = "b563d72f3e33c51406f4894fb1826ba1f80410c5"
SRC_URI = "git://github.com/trucrux/u-boot-trucrux.git;protocol=https;branch=${SRCBRANCH}"


S = "${WORKDIR}/git"

inherit fsl-u-boot-localversion

LOCALVERSION ?= "-${SRCBRANCH}"

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(mx6|mx6ul|mx7|imx6-truxq01)"
