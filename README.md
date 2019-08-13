### Automação de testes de contrato de API com Joi

- **Pré requisito**
  > [Android Studio](https://developer.android.com/studio) 
  > [Appium](https://github.com/appium/appium-desktop/releases/tag/v1.3.2) 
  

- **Variáveis de ambiente**:
  - Adicionar as linhas abaixo no arquivo '/home/seu_usuário/.bashrc'
```
export ANDROID_HOME=/home/rodrigo/Android/Sdk
export PATH=${PATH}:$ANDROID_HOME/tools:$ANDROID_HOME/platform-tools
```

- **Criar Emulador**:
```
Android Studio > AVD Manager > Create Virtual Device
```

- **Executar Emulador**:
```
sudo ~/Android/Sdk/emulator/emulator -avd Nexus_5X_API_28
```

- **Permissão de execução Appium**:
```
chmod +x appium-xxxx.AppImage
```

- **Executar Appium**:
```
./appium-xxxx.AppImage
```

- **Executar testes**:
```
IntelliJ > botão direito no diretório tests > Run
IntelliJ > arquivo de teste > botão direito no nome do teste > Run
IntelliJ > arquivo de teste > seção esquerda do arquivo > Run Test

```

#### Referências
