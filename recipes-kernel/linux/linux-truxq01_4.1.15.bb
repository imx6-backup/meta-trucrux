# Copyright (C) 2020 Trunexa Inc.
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Linux Kernel provided and supported by Freescale"
DESCRIPTION = "Linux Kernel provided and supported by Freescale with focus on \
i.MX Family Reference Boards. It includes support for many IPs such as GPU, VPU and IPU."

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

DEPENDS += "lzop-native bc-native"

#Branch based on imx_4.1.15_2.0.0_ga branch
SRCBRANCH = "trux-q01"
LOCALVERSION = "-2.0.1"
SRCREV = "1cd464db33313c7d6284fb96cf5cc5d1d1516d1c" 
SRC_URI = "git://github.com/trucrux/linux-trucrux.git;protocol=https;branch=${SRCBRANCH}"

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
