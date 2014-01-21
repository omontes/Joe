SELECT PCV.idProductoDev,P.Nombre,PCV.Cantidad,PCV.PrecioDev
FROM producto AS P,productocantidaddev AS PCV,devolucion AS D
WHERE P.idVersion=PCV.idVersionDev AND P.idProducto=PCV.idProductoDev AND PCV.idDevolucion=D.idDevolucion AND
D.idDevolucion=? AND D.Estado='A' AND PCV.idVersionDevProd=D.idVersionDev;
