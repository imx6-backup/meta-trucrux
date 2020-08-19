# Copyright (C) 2014 O.S. Systems Software LTDA.
# Copyright (C) 2014-2016 Freescale Semiconductor

SUMMARY = "Produces a Manufacturing Tool compatible Linux Kernel"
DESCRIPTION = "Linux Kernel provided and supported by Freescale that produces a \
Manufacturing Tool compatible Linux Kernel to be used in updater environment"

require linux-truxq01_${PV}.bb
require recipes-kernel/linux/linux-mfgtool.inc

KERNEL_IMAGE_BASE_NAME[vardepsexclude] = "DATETIME"
MODULE_IMAGE_BASE_NAME[vardepsexclude] = "DATETIME"
do_package[vardepsexclude] = "DATETIME"

do_configure_prepend() {
    cp ${S}/arch/arm/configs/trux_imx6ulq01_mfg_defconfig ${B}/.config
    cp ${S}/arch/arm/configs/trux_imx6ulq01_mfg_defconfig ${B}/../defconfig
}

do_deploy () {
    install -d ${DEPLOY_DIR_IMAGE}
    install  arch/arm/boot/zImage ${DEPLOY_DIR_IMAGE}/zImage_mfgtool
}

