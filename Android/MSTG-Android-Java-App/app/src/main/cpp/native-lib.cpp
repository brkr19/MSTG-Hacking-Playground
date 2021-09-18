//
// Created by Sven on 12/7/20.
//

#include <jni.h>
#include <string>

// https://developer.android.com/ndk/samples/sample_hellojni

extern "C" JNIEXPORT jstring

JNICALL
Java_sg_vp_owas_mobile_OMTG_Android_OMTG_1DATAST_1001_1SQLite_1Encrypted_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "S3cr3tString!!!";
    return env->NewStringUTF(hello.c_str());
}extern "C"
JNIEXPORT jstring JNICALL
Java_sg_vp_owasp_1mobile_OMTG_1Android_OMTG_1DATAST_1001_1SQLite_1Encrypted_stringFromJNI(
        JNIEnv *env, jobject thiz) {
    // TODO: implement stringFromJNI()

    std::string hello = "S3cr3tString!!!";
    return env->NewStringUTF(hello.c_str());
}

extern "C"
JNIEXPORT jboolean JNICALL
Java_sg_vp_owasp_1mobile_OMTG_1Android_OMTG_1CRYPTO_1003_1Signature_1Validation_isFirmwareValid(
        JNIEnv *env, jobject instance, jstring path) {
    const char *PGP_PUB_KEY =
            "-----BEGIN PGP PUBLIC KEY BLOCK-----"
            ""
            "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"
            "DAT8f8syxL8GNRw="
            "=Odut"
            "-----END PGP PUBLIC KEY BLOCK-----";
    const char *file_path = env->GetStringUTFChars(path, nullptr);

    return JNI_FALSE;
}