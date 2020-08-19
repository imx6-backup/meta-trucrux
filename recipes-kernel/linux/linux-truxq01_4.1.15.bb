# Copyright (C) 2020 Trunexa Inc.
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Linux Kernel provided and supported by Freescale"
DESCRIPTION = "Linux Kernel provided and supported by Freescale with focus on \
i.MX Family Reference Boards. It includes support for many IPs such as GPU, VPU and IPU."

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

DEPENDS += "lzop-native bc-native"

#SRCBRANCH = "imx_4.1.15_2.0.0_ga"
LOCALVERSION = "-2.0.1"
#SRCREV = "b63f3f52cb393e3287352cf63f0caef31a33ab63"
#SRC_URI = "git://source.codeaurora.org/external/imx/linux-imx;protocol=https;branch=${SRCBRANCH} \
# 	   file://0001-PATCH002-TRUX-iMX6UL-Q01-Linux4.1.15-V.2.0.0_Kernel_basic_customisation.patch"

SRCBRANCH = "trux-q01"
SRCREV = "bd724334ef22959b5f0f10f3d7d4aeb82c1861f1" 
SRC_URI = "git://github.com/trucrux/linux-trucrux.git;protocol=https;branch=${SRCBRANCH}

DEFAULT_PREFERENCE = "1"

DO_CONFIG_V7_COPY = "no"
DO_CONFIG_V7_COPY_mx6 = "yes"
DO_CONFIG_V7_COPY_mx6ul = "yes"
DO_CONFIG_V7_COPY_mx7 = "yes"

addtask copy_defconfig after do_patch before do_preconfigure #do_configure
do_copy_defconfig () {
    if [ ${DO_CONFIG_V7_COPY} = "yes" ]; then
        # copy latest trux_imx6ulq01_defconfig to use for mx6, mx6ul and mx7
        mkdir -p ${B}
        cp ${S}/arch/arm/configs/trux_imx6ulq01_defconfig ${B}/.config
        cp ${S}/arch/arm/configs/trux_imx6ulq01_defconfig ${B}/../defconfig
    fi
}

COMPATIBLE_MACHINE = "(mx6|mx6ul|mx7|imx6-truxq01)"
