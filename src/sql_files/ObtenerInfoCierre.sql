SELECT C.`TotalContado`,C.`TotalTarjeta`,C.`TotalVendido`
FROM cierredecaja AS C
WHERE C.idCierreDeCaja=?;
