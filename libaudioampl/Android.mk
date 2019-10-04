LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_C_INCLUDES += \
	$(call project-path-for,qcom-audio)/hal/msm8916/ \
	$(call project-path-for,qcom-audio)/hal/ \
	$(call project-path-for,qcom-audio)/hal/audio_extn \
	external/tinyalsa/include \
	external/tinycompress/include \
	system/media/audio_route/include

LOCAL_SHARED_LIBRARIES := liblog libutils libcutils libtinyalsa libtinycompress
LOCAL_HEADER_LIBRARIES := generated_kernel_headers
LOCAL_SRC_FILES := audio_amplifier.c
LOCAL_MODULE := audio_amplifier.msm8953
LOCAL_MODULE_RELATIVE_PATH := hw
LOCAL_MODULE_TAGS := optional
LOCAL_VENDOR_MODULE := true
LOCAL_HEADER_LIBRARIES += libhardware_headers

include $(BUILD_SHARED_LIBRARY)
