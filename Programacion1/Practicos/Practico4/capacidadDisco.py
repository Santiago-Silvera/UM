def calcCapacidad():
    cilindros = 12_000
    pistas = 16
    sectores = 8
    _bytes = 512
    capacidad = cilindros * pistas * sectores * _bytes
    tot_bytes = capacidad
    tot_kbytes = capacidad / 1024
    tot_mbytes = tot_kbytes / 1024
    tot_gbyes = tot_mbytes / 1024

    print(f"Capacidad: {capacidad}\n{tot_bytes} B\n{tot_kbytes} KB\n{tot_mbytes} MB\n{tot_gbyes} GB")